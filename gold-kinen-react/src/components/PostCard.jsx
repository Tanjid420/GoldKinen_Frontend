import  { useState } from 'react';
import { motion } from 'framer-motion';
import CommentList from './CommentList';
import PropTypes from 'prop-types';

const PostCard = ({ post, user, comments }) => {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <motion.div className="p-6 mb-4 bg-white rounded-lg shadow-md"
                initial={{ opacity: 0 }}
                animate={{ opacity: 1 }}
                transition={{ duration: 0.5 }}>
      <h3 className="text-xl font-bold mb-2">{post.title}</h3>
      <p className="text-gray-700">{post.body}</p>
      <p className="text-sm text-gray-500 mt-2">By: {user.name}</p>
      <button onClick={() => setIsOpen(!isOpen)} className="text-blue-500 mt-2">
        {isOpen ? 'Hide Comments' : 'Show Comments'}
      </button>
      {isOpen && (
        <motion.div initial={{ height: 0 }} animate={{ height: 'auto' }}>
          <CommentList comments={comments} />
        </motion.div>
      )}
    </motion.div>
  );
};

PostCard.propTypes = {
    post: PropTypes.shape({
      id: PropTypes.number.isRequired,
      title: PropTypes.string.isRequired,
      body: PropTypes.string.isRequired,
      userId: PropTypes.number.isRequired,
    }).isRequired,
    user: PropTypes.shape({
      id: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
    }).isRequired,
    comments: PropTypes.arrayOf(
      PropTypes.shape({
        id: PropTypes.number.isRequired,
        body: PropTypes.string.isRequired,
        email: PropTypes.string.isRequired,
        postId: PropTypes.number.isRequired,
      })
    ).isRequired,
  };

export default PostCard;
