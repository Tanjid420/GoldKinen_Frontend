import { useState, useEffect } from 'react';
import { fetchPosts, fetchUsers, fetchComments } from '../services/api';

const useFetchData = () => {
  const [data, setData] = useState({ posts: [], users: [], comments: [] });
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        const [postsResponse, usersResponse, commentsResponse] = await Promise.all([
          fetchPosts(),
          fetchUsers(),
          fetchComments()
        ]);
        setData({
          posts: postsResponse.data,
          users: usersResponse.data,
          comments: commentsResponse.data
        });
      } catch (err) {
        setError(err);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  return { data, loading, error };
};

export default useFetchData;
