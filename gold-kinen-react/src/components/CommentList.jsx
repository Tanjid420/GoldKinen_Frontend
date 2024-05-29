// import React from 'react';
import PropTypes from 'prop-types';
const CommentList = ({ comments }) => {
  return (
    <ul className="mt-8 pl-4 border-l border-gray-200">
      {comments.map(comment => (
        <li key={comment.id} className="mb-2">
          <p className="text-gray-800">{comment.body}</p>
          <div className='w-[300px]'>
          <p className="text-sm font-bold mt-2 text-transparent bg-clip-text bg-gradient-to-r from-pink-400 via-purple-600 to-indigo-500">- {comment.email}</p>
          </div>
        </li>
      ))}
    </ul>
  );
};


CommentList.propTypes = {
  comments: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      body: PropTypes.string.isRequired,
      email: PropTypes.string.isRequired,
    })
  ).isRequired,
};

export default CommentList;
